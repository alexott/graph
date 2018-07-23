config create_schema: false

inputfiledir = '/var/tmp/'
input = Graph.file(inputfiledir + 'air-routes.graphml').graphml()

// Specifies what data source to load using which mapper (as defined inline)
  
load(input.vertices()).asVertices {
    labelField "~label"
    key "~id", "id"
}

load(input.edges()).asEdges {
    labelField "~label"
    outV "outV", {
        labelField "~label"
        key "~id", "id"
    }
    inV "inV", {
        labelField "~label"
        key "~id", "id"
    }
}
