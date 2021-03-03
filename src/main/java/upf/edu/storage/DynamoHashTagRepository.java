package upf.edu.storage;

import twitter4j.Status;
import upf.edu.model.HashTagCount;

import java.io.Serializable;
import java.util.*;

public class DynamoHashTagRepository implements IHashtagRepository, Serializable {

  @Override
  public void write(Status tweet) {
    // IMPLEMENT ME
  }

  @Override
  public List<HashTagCount> readTop10(String lang) {
    // IMPLEMENT ME
    return Collections.emptyList();
  }

}
