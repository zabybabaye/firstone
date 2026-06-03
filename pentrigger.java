package com.example.pentest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/pentest")
public class PentestingPolicyTriggerController {
    @GetMapping("/patients/{patientId}/phi-summary")
    public ResponseEntity<PatientPhiSummary> getPatientPhiSummary(@PathVariable String patientId) {
        return ResponseEntity.ok(
            new PatientPhiSummary(
                patientId,
                "Jane",
                "Doe",
                "550-12-3456",
                "A+",
                "History of controlled hypertension"
            )
        );
    }
    public record PatientPhiSummary(
        String patientId,
        String givenName,
        String familyName,
        String governmentIdNumber,
        String bloodType,
        String diagnosisSummary
    ) {}
}
