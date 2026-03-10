-- Sample ClaimCenter data loaded on startup

INSERT INTO CLAIMS (claim_number, policyholder_name, description, claim_amount, status, created_at, updated_at)
VALUES
    ('CLM-1000000000001', 'Sipho Dlamini', 'Motor vehicle accident on N1 highway near Midrand. Third party collision, front and rear bumper damage. Vehicle towed to approved panel beater.', 45000.00, 'SUBMITTED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    ('CLM-1000000000002', 'Thandiwe Mokoena', 'Storm damage to residential property in Pretoria East. Roof tiles displaced, ceiling water damage in two rooms. Contractor assessment requested.', 78500.00, 'UNDER_REVIEW', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    ('CLM-1000000000003', 'Rethabile Khumalo', 'Slip and fall incident at commercial premises in Sandton. Third party injury claim submitted. Medical reports and witness statements attached.', 120000.00, 'APPROVED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    ('CLM-1000000000004', 'Nomvula Zulu', 'Household contents theft reported at residential address in Soweto. Police case number provided. List of stolen items submitted for assessment.', 35000.00, 'UNDER_REVIEW', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    ('CLM-1000000000005', 'Kagiso Sithole', 'Water pipe burst causing flooding in commercial property in Johannesburg CBD. Emergency repairs undertaken. Contractor invoices submitted.', 92000.00, 'SUBMITTED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);