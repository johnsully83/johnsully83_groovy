johnsully83
===========

*My personal website*

This is my own personal website, located at [johnsully83.com](http://johnsully83.com).  I originally made this back in college when auto-playing music and flashing lights on pages were still mildly popular, and have since created two other versions of it.  

This version is by far my most recent; I wrote it using Spring framework with JPA/Hibernate, MongoDB, and JSTL.  I largely use jQuery along with jQueryUI for front-end javascript, as well as Twitter Bootstrap to make everything a bit nicer overall.  Most of my CSS is entirely custom however.

Obviously most of it is resume-like stuff, put on the web for people to look at and hopefully be mildly impressed in some way.  However the sections under **Code** and **Math** may be interesting.  I have some [Project Euler](http://projecteuler.net/) solutions up there in both Python and JAVA: nothing too complicated, and most of it was stuff I did in college when bored with JAVA coursework, and then separately to teach myself a bit of Python.

However I do also a page utilizing the [Yahoo Geoplanet API](http://developer.yahoo.com/geo/geoplanet/), displaying Country names in [jQuery DataTables](https://datatables.net/).  This data is replicated nightly and stored in both MySQL (for backup purposes) and MongoDB (that's what backs the DataTables for fast query speeds) databases.  Similarly I have a page that performs currency conversions, utilizing the [Open Exchange Rates free API](https://openexchangerates.org/).  It similarly replicates the data nightly, keeping historical records which you can choose to use during conversion.  Again it throws the data into MySQL and MongoDB databases during those replication processes.

My favorite part of the site is under the **Math** section.  The page called *Primes* (the *Proofs* page is still empty; I've been too lazy to format the ones I do have in digital form for the web) hosts a DataTable of the prime numbers I currently have stored in my Mongo database.  That database is constantly being filled by a different thread; you should be able to refresh the table and see new numbers as they're being added.  The database is currently about 42GB in size, storing essentially only the prime number itself and some other basic record information.  The largest prime I've calculated (starting at 2 and going up) is 5074457567 as of this writing.

Anyways I welcome suggestions, either UI or back-end related.