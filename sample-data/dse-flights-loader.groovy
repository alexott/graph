config create_schema: true

inputfiledir = './'
recipeInput = Graph.file(inputfiledir + 'air-routes.graphml').graphml()

// Specifies what data source to load using which mapper (as defined inline)
  
load(recipeInput.vertices()).asVertices {
    labelField "~label"
    key "~id", "id"
}

load(recipeInput.edges()).asEdges {
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
