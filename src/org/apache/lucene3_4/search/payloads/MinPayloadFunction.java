package org.apache.lucene3_4.search.payloads;

import org.apache.lucene3_4.search.Explanation;

/**
 * Calculates the minimum payload seen
 *
 **/
public class MinPayloadFunction extends PayloadFunction {

  @Override
	public float currentScore(int docId, String field, int start, int end, int numPayloadsSeen, float currentScore, float currentPayloadScore) {
    if (numPayloadsSeen == 0) {
      return currentPayloadScore;
    } else {
		return Math.min(currentPayloadScore, currentScore);
	}
  }

  @Override
  public float docScore(int docId, String field, int numPayloadsSeen, float payloadScore) {
    return numPayloadsSeen > 0 ? payloadScore : 1;
  }
  
  @Override
  public Explanation explain(int doc, int numPayloadsSeen, float payloadScore) {
	  Explanation expl = new Explanation();
	  float minPayloadScore = (numPayloadsSeen > 0 ? payloadScore : 1);
	  expl.setValue(minPayloadScore);
	  expl.setDescription("MinPayloadFunction(...)");
	  return expl;
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
