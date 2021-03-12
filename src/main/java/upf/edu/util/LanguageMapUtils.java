package upf.edu.util;

import java.util.Arrays;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;

import scala.Tuple2;

public class LanguageMapUtils {

    public static JavaPairRDD<String, String> buildLanguageMap(JavaRDD<String> lines) {
    	 return lines.map(l -> Arrays.asList(l.split("\\t")))
                 .filter(l -> l.size() > 2)
                 .mapToPair(l -> (l.get(1).length() == 2) ? //Change to if else 
                         (new Tuple2<String, String>(l.get(1), l.get((2)))) :
                         (new Tuple2<String, String>(l.get(0), l.get(2))));
    }
}
