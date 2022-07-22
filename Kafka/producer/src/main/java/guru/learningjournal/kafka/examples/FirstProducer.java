package guru.learningjournal.kafka.examples;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class FirstProducer {
    private static final Logger logger= LogManager.getLogger();
    public static void main(String[] args){
        logger.info("Creating Producer:");
        Properties props=new Properties();
        //Setting Configurations
        props.put(ProducerConfig.CLIENT_ID_CONFIG,AppConfigs.applicationID);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,AppConfigs.bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //Creating Producer Object
        KafkaProducer<Integer,String> producer=new KafkaProducer<Integer, String>(props);
        //Sending Messages
        logger.info("Start Sending Messages.");
        for (int i=0;i<AppConfigs.numEvents;i++){

            producer.send(new ProducerRecord(AppConfigs.topicName,i,"Sample Message:"+i));
        }
        logger.info("Message Sending Finished!");
        producer.close();

    }
}
