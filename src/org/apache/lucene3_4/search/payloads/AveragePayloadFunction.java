package org.apache.lucene3_4.search.payloads;

import org.apache.lucene3_4.search.Explanation;


/**
 * Calculate the final score as the average score of all payloads seen.
 * <p/>
 * Is thread safe and completely reusable. 
 *
 **/
public class AveragePayloadFunction extends PayloadFunction{

  @Override
  public float currentScore(int docId, String field, int start, int end, int numPayloadsSeen, float currentScore, float currentPayloadScore) {
    return currentPayloadScore + currentScore;
  }

  @Override
  public float docScore(int docId, String field, int numPayloadsSeen, float payloadScore) {
    return numPayloadsSeen > 0 ? (payloadScore / numPayloadsSeen) : 1;
  }
  @Override
  public Explanation explain(int doc, int numPayloadsSeen, float payloadScore) {
      Explanation payloadBoost = new Explanation();
      float avgPayloadScore = (numPayloadsSeen > 0 ? (payloadScore / numPayloadsSeen) : 1);
      payloadBoost.setValue(avgPayloadScore);
      payloadBoost.setDescription("AveragePayloadFunction(...)");
      return payloadBoost;
  } 

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.getClass().hashCode();
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    return true;
  }
}
