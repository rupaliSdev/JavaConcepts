### Understanding static:

* Static means the member belongs to the class, not to objects.
* Static methods can be called without creating an object and can access only static data.
* They cannot use this or super because no object exists in a static context.
* Static blocks run once when the class is loaded, mainly for initializing static variables.
* Static methods cannot be overridden since they are resolved at compile time, not runtime.