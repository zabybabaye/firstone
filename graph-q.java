import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import java.util.Map;

import static graphql.Scalars.GraphQLString;

public class GraphQLExample {

    public static void main(String[] args) {

        // Define schema programmatically
        GraphQLObjectType queryType = GraphQLObjectType.newObject()
                .name("Query")
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("hello")
                        .type(GraphQLString)
                        .dataFetcher(environment -> "Hello from GraphQL Java! 🚀")
                )
                .build();

        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();

        // Build GraphQL engine
        GraphQL graphQL = GraphQL.newGraphQL(schema).build();

        // Define query
        String query = "{ hello }";

        // Execute query
        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                .query(query)
                .build();

        ExecutionResult executionResult = graphQL.execute(executionInput);

        // Print result
        Map<String, Object> result = executionResult.getData();
        System.out.println("Result: " + result);

        // Print errors if any
        if (!executionResult.getErrors().isEmpty()) {
            System.out.println("Errors: " + executionResult.getErrors());
        }
    }
}
