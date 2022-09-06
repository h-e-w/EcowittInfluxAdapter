package works.hardly_ever.ecowittinfluxadapter.svc;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.InfluxDBClientOptions;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import works.hardly_ever.ecowittinfluxadapter.domain.EcowittDataPacket;
import works.hardly_ever.ecowittinfluxadapter.domain.InfluxDataPoint;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@Service
public class InfluxService {

    private final Logger log = LoggerFactory.getLogger(InfluxService.class);
    @Value("${works.hardly_ever.influxUrl}")
    private String influxUrl;
    @Value("${works.hardly_ever.influxToken}")
    private String influxToken;
    @Value("${works.hardly_ever.influxOrg}")
    private String influxOrg;
    @Value("${works.hardly_ever.influxBucket}")
    private String influxBucket;

    InfluxDBClient influxDBClient;

    public InfluxService() {

    }


    /**
     * Take an EcowittDataPacket (i.e. the submitted form data), convert to sane units and log in InfluxDB.
     *
     * @param data
     */
    public void writeData(EcowittDataPacket data) {
        InfluxDataPoint influxData = new InfluxDataPoint(data);
        log.debug("Created influx data point " + influxData);
        InfluxDBClientOptions opts = InfluxDBClientOptions.builder().authenticateToken(influxToken.toCharArray()).org(influxOrg).bucket(influxBucket).url(influxUrl).build();
        log.debug("Options: " + opts.getToken());
        influxDBClient = InfluxDBClientFactory.create(opts);
        WriteApiBlocking writeApi = influxDBClient.getWriteApiBlocking();
        log.debug("Connected to InfluxDB");
        long epochMilli = Instant.now().toEpochMilli();

        List<Point> points = new LinkedList<>();
        if (influxData.isProbablyLostConnection()) {
            log.info("Looks like external connection lost so not recording those measurements");
        } else {
            points.add(
                    Point.measurement("temperature")
                            .addTag("location", "outside")
                            .addField("value", influxData.getExternelTemp())
                            .time(epochMilli, WritePrecision.MS)
            );
            points.add(
                    Point.measurement("humidity")
                            .addTag("location", "outside")
                            .addField("value", influxData.getExternalHumidity())
                            .time(epochMilli, WritePrecision.MS)
            );
            points.add(
                    Point.measurement("dailyrain")
                            .addTag("location", "outside")
                            .addField("value", influxData.getDailyRain())
                            .time(epochMilli, WritePrecision.MS)
            );
            points.add(
                    Point.measurement("rainrate")
                            .addTag("location", "outside")
                            .addField("value", influxData.getRainRate())
                            .time(epochMilli, WritePrecision.MS)
            );
            points.add(
                    Point.measurement("solarrad")
                            .addTag("location", "outside")
                            .addField("value", influxData.getSolarRad())
                            .time(epochMilli, WritePrecision.MS)
            );
            points.add(
                    Point.measurement("uvindex")
                            .addTag("location", "outside")
                            .addField("value", influxData.getUvIndex())
                            .time(epochMilli, WritePrecision.MS)
            );
            points.add(
                    Point.measurement("winddir")
                            .addTag("location", "outside")
                            .addField("value", influxData.getWinddir())
                            .time(epochMilli, WritePrecision.MS)
            );
            points.add(
                    Point.measurement("windspeed")
                            .addTag("location", "outside")
                            .addField("value", influxData.getWindSpeed())
                            .time(epochMilli, WritePrecision.MS)
            );
            points.add(
                    Point.measurement("windgust")
                            .addTag("location", "outside")
                            .addField("value", influxData.getWindGust())
                            .time(epochMilli, WritePrecision.MS)
            );
        }

        points.add(
                Point.measurement("temperature")
                        .addTag("location", "inside")
                        .addField("value", influxData.getInternalTemp())
                        .time(epochMilli, WritePrecision.MS)
        );
        points.add(
                Point.measurement("pressure")
                        .addTag("location", "inside")
                        .addField("value", influxData.getInternalBarometerAbs())
                        .time(epochMilli, WritePrecision.MS)
        );
        points.add(
                Point.measurement("humidity")
                        .addTag("location", "inside")
                        .addField("value", influxData.getInternalHumidity())
                        .time(epochMilli, WritePrecision.MS)
        );

        writeApi.writePoints(points);
        log.info("Written points");
        influxDBClient.close();
        log.debug("Connection closed");
    }

}
