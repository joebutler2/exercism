class Hamming {
  companion object {
    fun compute(strand: String, otherStrand: String) : Int {
      if(strand.isEmpty() && otherStrand.isEmpty()) return 0
      var distance = 0
      val strandIterator = strand.iterator()
      val otherStrandIterator = otherStrand.iterator()
      while (strandIterator.hasNext() && otherStrandIterator.hasNext()) {
        if(!strandIterator.nextChar().equals(otherStrandIterator.nextChar())) {
          distance++;
        }
      }
      if(strandIterator.hasNext() || otherStrandIterator.hasNext()) {
        throw IllegalArgumentException("left and right strands must be of equal length.")
      }
      return distance
    }
  }
}