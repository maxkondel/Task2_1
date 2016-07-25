package task;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="train")
public class Train {

    private Integer id;
    private String trainFrom;
    private String trainTo;
    private String date;
    private String departure;

    public Train() {}

    public Train(Integer id,String trainFrom, String trainTo, String date, String departure) {
        this.id = id;
        this.trainFrom = trainFrom;
        this.trainTo = trainTo;
        this.date = date;
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "[" + id + ", " + trainFrom + ", " + trainTo + ", " + date +", " +departure+ "]";
    }


    public Integer getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrainFrom() {
        return trainFrom;
    }

    @XmlElement
    public void setTrainFrom(String trainFrom) {
        this.trainFrom = trainFrom;
    }

    public String getTrainTo() {
        return trainTo;
    }

    @XmlElement
    public void setTrainTo(String trainTo) {
        this.trainTo = trainTo;
    }

    public String getDate() {
        return date;
    }

    @XmlElement
    public void setDate(String date) {
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }

    @XmlElement
    public void setDeparture(String departure) {
        this.departure = departure;
    }

}
