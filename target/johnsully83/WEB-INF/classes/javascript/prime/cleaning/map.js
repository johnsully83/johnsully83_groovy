function() {
	if(lastPrimeID >= 0) {
		if(lastPrimeID != (this.id - 1)) {
			emit(lastPrimeID+1, {nextKnownPrime: this.prime});
		}
		
		lastPrimeID = this.id;
	}
}