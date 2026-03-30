package com.example.governance.seed;

import java.util.List;

public class PaymentDataExposedRuleSeeder {

    public List<GovernanceRule> getRules() {
        return List.of(
            createRuleForAnyRepository(
                "Payment Data Exposed by an API",
                GovernanceRuleCategory.WEAKNESS,
                List.of("Penetration Testing", "Compliance Review (PCI)"),
                new RulePortionWithSubType<>(
                    GovernanceWhenType.SENSITIVE_DATA,
                    SensitiveDataType.PAYMENTS.name(),
                    CodeGovernanceKeys.EXPOSED
                ),
                "Payment data is exposed in an API",
                createRiskAction(RiskLevel.HIGH),
                createLabelAction(GovernanceThenSubType.ADDED, "Payment data exposed by an API")
            )
        );
    }

    // --- Helper methods (mocked for example) ---

    private GovernanceRule createRuleForAnyRepository(
            String name,
            GovernanceRuleCategory category,
            List<String> processTags,
            RulePortionWithSubType<GovernanceWhenType, String> when,
            String description,
            RiskAction riskAction,
            LabelAction labelAction
    ) {
        return new GovernanceRule(
                name,
                category,
                "ANY", // Repository = Any
                processTags,
                when,
                description,
                riskAction,
                labelAction
        );
    }

    private RiskAction createRiskAction(RiskLevel level) {
        return new RiskAction(level);
    }

    private LabelAction createLabelAction(GovernanceThenSubType type, String label) {
        return new LabelAction(type, label);
    }
}
