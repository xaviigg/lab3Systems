package upf.edu;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.twitter.TwitterUtils;
import twitter4j.Status;
import twitter4j.auth.OAuthAuthorization;
import upf.edu.util.ConfigUtils;

import java.io.IOException;

public class TwitterWindowExample {

    public static void main(String[] args) throws InterruptedException, IOException {
        String propertiesFile = args[0];
        OAuthAuthorization auth = ConfigUtils.getAuthorizationFromFileProperties(propertiesFile);

        SparkConf conf = new SparkConf().setAppName("Real-time Twitter Example");
        JavaStreamingContext jsc = new JavaStreamingContext(conf, Durations.seconds(10));
        // This is needed by spark to write down temporary data
        jsc.checkpoint("/tmp/checkpoint");

        final JavaReceiverInputDStream<Status> stream = TwitterUtils.createStream(jsc, auth);

        // Create a window with a duration of 30 seconds (will contain 3 micro-batches)
        final JavaDStream<Status> windowedStream = stream.window(Durations.seconds(30));

        stream.count().print();
        windowedStream.count().print();

        // Start the application and wait for termination signal
        jsc.start();
        jsc.awaitTermination();
    }

}
