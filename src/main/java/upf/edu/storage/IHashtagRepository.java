package upf.edu.storage;

import twitter4j.Status;
import upf.edu.model.HashTagCount;

import java.util.List;

public interface IHashtagRepository {

  /**
   * Read top 10 hashtags
   * @param lang
   * @return
   */
  List<HashTagCount> readTop10(String lang);

  /**
   * Write on storage an element of type T
   * in the expected format
   * @param h
   */
  void write(Status h);
}
