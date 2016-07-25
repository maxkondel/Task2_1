package task;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Integer id= 0;
        TrainTimeTable trainTimeTable = new TrainTimeTable();
        trainTimeTable.add(new Train(++id,"Kiev","Donetsk","19.12.2013","15:05"));
        trainTimeTable.add(new Train(++id,"Lviv","Donetsk","19.12.2013","19:05"));

        Boolean flag=true;
        Train train = new Train();
        Scanner in = new Scanner(System.in);
        while (flag){
            System.out.println("Input Train..(if no press n)");
            String s = in.next();
            if (!s.equals("n")) {

                train.setId(++id);
                train.setTrainFrom(s);
                train.setTrainTo(in.next());
                train.setDate(in.next());
                train.setDeparture(in.next());
                trainTimeTable.add(train);
            }
            else
                flag = false;
        }

        try {
            File file = new File("F:\\Trains.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(TrainTimeTable.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(trainTimeTable, file);
            marshaller.marshal(trainTimeTable, System.out);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            trainTimeTable = (TrainTimeTable) unmarshaller.unmarshal(file);
            System.out.println(trainTimeTable);
            System.out.println();
        } catch (JAXBException e) {
            e.printStackTrace();
        }


            SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy HH:mm");
            System.out.println(trainTimeTable.filter(ft.parse("19.12.2013 15:00"),ft.parse("19.12.2013 19:00")));
    }
}
