using Lim.Common.DotNET;
using Microsoft.Extensions.Logging;

namespace Lim.Migrator;

public class Seed018PaymentData(
    ILogger<IDatabaseSeeder> logger,
    IGovernanceRulesStorage governanceRulesStorage,
    IProcessTagsStorage processTagsStorage
) : BaseGovernanceRulesSeeder(logger, governanceRulesStorage, processTagsStorage)
{
    public override IReadOnlyCollection<GovernanceRule> GetRulesForSeed(IReadOnlyCollection<GovernanceRule> existingRules)
        =>
        [
            CreateRuleForAnyRepository(
                "Payment Data Exposed by an API",
                GovernanceRuleCategory.Weakness,
                GetProcessTagsByNames("Penetration Testing", "Compliance Review (PCI)"),
                new RulePortionWithSubType<GovernanceWhenType, string>
                {
                    Type = GovernanceWhenType.SensitiveData,
                    SubType = nameof(SensitiveDataType.Payments),
                    Value = CodeGovernanceKeys.Exposed
                },
                "Payment data is exposed in an API",
                CreateRiskAction(RiskLevel.High),
                CreateLabelAction(GovernanceThenSubType.Added, "Payment data exposed by an API")
            )
        ];
}
