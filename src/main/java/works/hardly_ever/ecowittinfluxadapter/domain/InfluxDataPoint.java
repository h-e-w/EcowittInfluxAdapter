package works.hardly_ever.ecowittinfluxadapter.domain;

/**
 * Very simple PoJo to represent the data points to be logged in InfluxDB
 */
public class InfluxDataPoint {
    double internalTemp;
    long internalHumidity;
    double internalBarometerAbs;
    double externelTemp;
    long externalHumidity;
    long winddir;
    double windSpeed;
    double windGust;
    double rainRate;
    double dailyRain;
    double solarRad;
    long uvIndex;
    boolean probablyLostConnection=false;

    /**
     * Take the data given to us by the weather station, convert the values to more normal units and check if it looks
     * like the connection to the external unit has been lost.
     * @param ewData
     */
    public InfluxDataPoint(EcowittDataPacket ewData){
        internalTemp = (ewData.getTempinf() -32)/1.8;
        internalHumidity= ewData.getHumidityin();
        internalBarometerAbs=ewData.getBaromabsin() * 33.86389;
        externelTemp = (ewData.getTempf() -32)/1.8;
        externalHumidity = ewData.getHumidity();
        winddir = ewData.getWinddir();
        windSpeed = ewData.getWindspeedmph() * 0.44704;
        windGust = ewData.getWindgustmph() * 0.44704;
        rainRate = ewData.getRainratein() / 0.039370;
        dailyRain = ewData.getDailyrainin() / 0.039370;
        solarRad = ewData.getSolarradiation();
        uvIndex = ewData.getUv();
        // If the inside and outside unit lose connection we get a load of zeros we won't want to log
        if(ewData.getTempf()==0 && ewData.getHumidity()==0&&ewData.winddir==0){
            probablyLostConnection=true;
        }
    }

    public double getInternalTemp() {
        return internalTemp;
    }

    public void setInternalTemp(double internalTemp) {
        this.internalTemp = internalTemp;
    }

    public long getInternalHumidity() {
        return internalHumidity;
    }

    public void setInternalHumidity(long internalHumidity) {
        this.internalHumidity = internalHumidity;
    }

    public double getInternalBarometerAbs() {
        return internalBarometerAbs;
    }

    public void setInternalBarometerAbs(double internalBarometerAbs) {
        this.internalBarometerAbs = internalBarometerAbs;
    }

    public double getExternelTemp() {
        return externelTemp;
    }

    public void setExternelTemp(double externelTemp) {
        this.externelTemp = externelTemp;
    }

    public long getExternalHumidity() {
        return externalHumidity;
    }

    public void setExternalHumidity(long externalHumidity) {
        this.externalHumidity = externalHumidity;
    }

    public long getWinddir() {
        return winddir;
    }

    public void setWinddir(long winddir) {
        this.winddir = winddir;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindGust() {
        return windGust;
    }

    public void setWindGust(double windGust) {
        this.windGust = windGust;
    }

    public double getRainRate() {
        return rainRate;
    }

    public void setRainRate(double rainRate) {
        this.rainRate = rainRate;
    }

    public double getDailyRain() {
        return dailyRain;
    }

    public void setDailyRain(double dailyRain) {
        this.dailyRain = dailyRain;
    }

    public double getSolarRad() {
        return solarRad;
    }

    public void setSolarRad(double solarRad) {
        this.solarRad = solarRad;
    }

    public long getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(long uvIndex) {
        this.uvIndex = uvIndex;
    }

    public boolean isProbablyLostConnection() {
        return probablyLostConnection;
    }

    public void setProbablyLostConnection(boolean probablyLostConnection) {
        this.probablyLostConnection = probablyLostConnection;
    }

    @Override
    public String toString() {
        return "InfluxDataPoint{" +
                "internalTemp=" + internalTemp +
                ", internalHumidity=" + internalHumidity +
                ", internalBarometerAbs=" + internalBarometerAbs +
                ", externelTemp=" + externelTemp +
                ", externalHumidity=" + externalHumidity +
                ", winddir=" + winddir +
                ", windSpeed=" + windSpeed +
                ", windGust=" + windGust +
                ", rainRate=" + rainRate +
                ", dailyRain=" + dailyRain +
                ", solarRad=" + solarRad +
                ", uvIndex=" + uvIndex +
                ", probablyLostConnection=" + probablyLostConnection +
                '}';
    }
}
