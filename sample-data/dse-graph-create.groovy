system.graph('Flights').ifNotExists().create()
:remote config alias g Flights.g

// This is done only for interactive development, and shouldn't be used for production
schema.config().option('graph.schema_mode').set('Development')
schema.config().option('graph.allow_scan').set('true')
schema.config().option("tx_autostart").set(true)

