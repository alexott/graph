Data could be loaded into DSE Graph either using Graph.IO API with code like this executed in the Gremlin Console:

```groovy
graph.io(graphml()).readGraph("/var/tmp/air-routes.graphml");
```

But the preferable way will be to load sample data using the [DSE Graph Loader](https://docs.datastax.com/en/dse/6.0/dse-dev/datastax_enterprise/graph/dgl/graphloaderTOC.html) using following commands:

```sh
# create graph
dse gremlin-console -e dse-graph-create.groovy
# create graph schema
dse gremlin-console -e dse-graph-schema.groovy
# load data
<path_to_dgl>/graphloader ~/work/graph/flights-loader.groovy -graph Flights -address localhost
```

**Caveats**: Either of previous command loads data successfully, but there is a slight difference comparing to the use of TinkerGraph - the IDs for vertices & edges are automatically generated during the load, so you can't use `g.V(3)`, but you need to use `g.V().has('airport', 'id', '3')` instead.  This is a limitation of the GraphML support in the DSE Graph.

