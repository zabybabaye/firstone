package com.example.sensitivedata.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sensitive-data")
public class SensitiveDataController {

    @PostMapping("/predict")
    public ResponseEntity<SensitiveDataResponse> predictSensitiveData(
            @RequestBody SensitiveDataRequest request
    ) {
        // Example stub logic
        SensitiveDataMatch creditCardMatch = new SensitiveDataMatch(
                "CreditCard",
                "payment.creditCardNumber",
                List.of("PCI", "Financial")
        );

        SensitiveDataResponse response = new SensitiveDataResponse(
                request.getLanguage(),
                request.getEntity(),
                true,
                List.of(creditCardMatch),
                Map.of("source", "example-java-api")
        );

        return ResponseEntity.ok(response);
    }

    public static class SensitiveDataRequest {
        private String language;
        private String entity;
        private Map<String, String> typeToRelativeFeaturesPath;
        private List<CustomSensitiveDataDefinition> customSensitiveDataDefinitions;

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getEntity() {
            return entity;
        }

        public void setEntity(String entity) {
            this.entity = entity;
        }

        public Map<String, String> getTypeToRelativeFeaturesPath() {
            return typeToRelativeFeaturesPath;
        }

        public void setTypeToRelativeFeaturesPath(Map<String, String> typeToRelativeFeaturesPath) {
            this.typeToRelativeFeaturesPath = typeToRelativeFeaturesPath;
        }

        public List<CustomSensitiveDataDefinition> getCustomSensitiveDataDefinitions() {
            return customSensitiveDataDefinitions;
        }

        public void setCustomSensitiveDataDefinitions(List<CustomSensitiveDataDefinition> customSensitiveDataDefinitions) {
            this.customSensitiveDataDefinitions = customSensitiveDataDefinitions;
        }
    }

    public static class CustomSensitiveDataDefinition {
        private String name;
        private List<String> exactMatch;
        private List<String> multipleTokens;
        private List<String> wildcards;
        private List<String> excludeExactMatch;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getExactMatch() {
            return exactMatch;
        }

        public void setExactMatch(List<String> exactMatch) {
            this.exactMatch = exactMatch;
        }

        public List<String> getMultipleTokens() {
            return multipleTokens;
        }

        public void setMultipleTokens(List<String> multipleTokens) {
            this.multipleTokens = multipleTokens;
        }

        public List<String> getWildcards() {
            return wildcards;
        }

        public void setWildcards(List<String> wildcards) {
            this.wildcards = wildcards;
        }

        public List<String> getExcludeExactMatch() {
            return excludeExactMatch;
        }

        public void setExcludeExactMatch(List<String> excludeExactMatch) {
            this.excludeExactMatch = excludeExactMatch;
        }
    }

    public static class SensitiveDataMatch {
        private String type;
        private String field;
        private List<String> tags;

        public SensitiveDataMatch(String type, String field, List<String> tags) {
            this.type = type;
            this.field = field;
            this.tags = tags;
        }

        public String getType() {
            return type;
        }

        public String getField() {
            return field;
        }

        public List<String> getTags() {
            return tags;
        }
    }

    public static class SensitiveDataResponse {
        private String language;
        private String entity;
        private boolean sensitive;
        private List<SensitiveDataMatch> matches;
        private Map<String, String> metadata;

        public SensitiveDataResponse(
                String language,
                String entity,
                boolean sensitive,
                List<SensitiveDataMatch> matches,
                Map<String, String> metadata
        ) {
            this.language = language;
            this.entity = entity;
            this.sensitive = sensitive;
            this.matches = matches;
            this.metadata = metadata;
        }

        public String getLanguage() {
            return language;
        }

        public String getEntity() {
            return entity;
        }

        public boolean isSensitive() {
            return sensitive;
        }

        public List<SensitiveDataMatch> getMatches() {
            return matches;
        }

        public Map<String, String> getMetadata() {
            return metadata;
        }
    }
}
