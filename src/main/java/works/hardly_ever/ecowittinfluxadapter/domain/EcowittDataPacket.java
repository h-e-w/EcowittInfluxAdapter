package works.hardly_ever.ecowittinfluxadapter.domain;

import java.util.Date;

/**
 * Very simple PoJo to hold the values sent to us by the weather station.
 */
public class EcowittDataPacket {
    String PASSKEY;
    String stationtype;
    String dateutc;
    double tempinf;
    long humidityin;
    double baromrelin;
    double baromabsin;
    double tempf;
    long humidity;
    long winddir;
    double windspeedmph;
    double windgustmph;
    double maxdailygust;
    double rainratein;
    double eventrainin;
    double hourlyrainin;
    double dailyrainin;
    double weeklyrainin;
    double monthlyrainin;
    double yearlyrainin;
    double totalrainin;
    double solarradiation;
    long uv;
    long wh65batt;
    String freq;
    String model;

    public String getPASSKEY() {
        return PASSKEY;
    }

    public void setPASSKEY(String PASSKEY) {
        this.PASSKEY = PASSKEY;
    }

    public String getStationtype() {
        return stationtype;
    }

    public void setStationtype(String stationtype) {
        this.stationtype = stationtype;
    }

    public String getDateutc() {
        return dateutc;
    }

    public void setDateutc(String dateutc) {
        this.dateutc = dateutc;
    }

    public double getTempinf() {
        return tempinf;
    }

    public void setTempinf(double tempinf) {
        this.tempinf = tempinf;
    }

    public long getHumidityin() {
        return humidityin;
    }

    public void setHumidityin(long humidityin) {
        this.humidityin = humidityin;
    }

    public double getBaromrelin() {
        return baromrelin;
    }

    public void setBaromrelin(double baromrelin) {
        this.baromrelin = baromrelin;
    }

    public double getBaromabsin() {
        return baromabsin;
    }

    public void setBaromabsin(double baromabsin) {
        this.baromabsin = baromabsin;
    }

    public double getTempf() {
        return tempf;
    }

    public void setTempf(double tempf) {
        this.tempf = tempf;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public long getWinddir() {
        return winddir;
    }

    public void setWinddir(long winddir) {
        this.winddir = winddir;
    }

    public double getWindspeedmph() {
        return windspeedmph;
    }

    public void setWindspeedmph(double windspeedmph) {
        this.windspeedmph = windspeedmph;
    }

    public double getWindgustmph() {
        return windgustmph;
    }

    public void setWindgustmph(double windgustmph) {
        this.windgustmph = windgustmph;
    }

    public double getMaxdailygust() {
        return maxdailygust;
    }

    public void setMaxdailygust(double maxdailygust) {
        this.maxdailygust = maxdailygust;
    }

    public double getRainratein() {
        return rainratein;
    }

    public void setRainratein(double rainratein) {
        this.rainratein = rainratein;
    }

    public double getEventrainin() {
        return eventrainin;
    }

    public void setEventrainin(double eventrainin) {
        this.eventrainin = eventrainin;
    }

    public double getHourlyrainin() {
        return hourlyrainin;
    }

    public void setHourlyrainin(double hourlyrainin) {
        this.hourlyrainin = hourlyrainin;
    }

    public double getDailyrainin() {
        return dailyrainin;
    }

    public void setDailyrainin(double dailyrainin) {
        this.dailyrainin = dailyrainin;
    }

    public double getWeeklyrainin() {
        return weeklyrainin;
    }

    public void setWeeklyrainin(double weeklyrainin) {
        this.weeklyrainin = weeklyrainin;
    }

    public double getMonthlyrainin() {
        return monthlyrainin;
    }

    public void setMonthlyrainin(double monthlyrainin) {
        this.monthlyrainin = monthlyrainin;
    }

    public double getYearlyrainin() {
        return yearlyrainin;
    }

    public void setYearlyrainin(double yearlyrainin) {
        this.yearlyrainin = yearlyrainin;
    }

    public double getTotalrainin() {
        return totalrainin;
    }

    public void setTotalrainin(double totalrainin) {
        this.totalrainin = totalrainin;
    }

    public double getSolarradiation() {
        return solarradiation;
    }

    public void setSolarradiation(double solarradiation) {
        this.solarradiation = solarradiation;
    }

    public long getUv() {
        return uv;
    }

    public void setUv(long uv) {
        this.uv = uv;
    }

    public long getWh65batt() {
        return wh65batt;
    }

    public void setWh65batt(long wh65batt) {
        this.wh65batt = wh65batt;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "EcowittDataPacket{" +
                "PASSKEY='" + PASSKEY + '\'' +
                ", stationtype='" + stationtype + '\'' +
                ", dateutc=" + dateutc +
                ", tempinf=" + tempinf +
                ", humidityin=" + humidityin +
                ", baromrelin=" + baromrelin +
                ", baromabsin=" + baromabsin +
                ", tempf=" + tempf +
                ", humidity=" + humidity +
                ", winddir=" + winddir +
                ", windspeedmph=" + windspeedmph +
                ", windgustmph=" + windgustmph +
                ", maxdailygust=" + maxdailygust +
                ", rainratein=" + rainratein +
                ", eventrainin=" + eventrainin +
                ", hourlyrainin=" + hourlyrainin +
                ", dailyrainin=" + dailyrainin +
                ", weeklyrainin=" + weeklyrainin +
                ", monthlyrainin=" + monthlyrainin +
                ", yearlyrainin=" + yearlyrainin +
                ", totalrainin=" + totalrainin +
                ", solarradiation=" + solarradiation +
                ", uv=" + uv +
                ", wh65batt=" + wh65batt +
                ", freq='" + freq + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
