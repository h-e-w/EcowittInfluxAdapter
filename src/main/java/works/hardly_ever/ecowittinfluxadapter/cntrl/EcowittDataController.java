package works.hardly_ever.ecowittinfluxadapter.cntrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import works.hardly_ever.ecowittinfluxadapter.domain.EcowittDataPacket;
import works.hardly_ever.ecowittinfluxadapter.svc.InfluxService;

/**
 * Present a URI that the weather station can call POST on to send us data
 */
@Controller
public class EcowittDataController {

    private final Logger log = LoggerFactory.getLogger(EcowittDataController.class);

    private final InfluxService influxService;

    public EcowittDataController(InfluxService influxService) {
        this.influxService = influxService;
    }

    /**
     * Show something more sane than a 404 if someone browses here
     * @return
     */
    @GetMapping
    @ResponseBody
    public String getResponse(){
        return "This service should be called via a POST from Ecowitt device";
    }

    /**
     * Receive a POST from the weather station with some measurements.  Pass it off to InfluxService to save in DB.
     * @param formData
     * @return
     */
    @PostMapping(value="/data/report")
    @ResponseBody
    public String receiveData(EcowittDataPacket formData){
        log.info("Called by weather station");
        log.debug("Got data: "+formData);
        influxService.writeData(formData);
        return "OK";
    }

}
