function(key, values) {
	var result = {firstIndexToFind: 0, nextKnownPrime: 0, duplicateEntries: 0, allPrimesForIndex: []};
	
	for (var i=0; i < values.length; i++) {
		if(result.firstIndexToFind == 0) {
			result.firstIndexToFind = key;
			result.nextKnownPrime = values[i].nextKnownPrime;
		}
		
		result.duplicateEntries++;
		result.allPrimesForIndex.push(values[i]);
	}

	return result;
}