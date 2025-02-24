-------------------
-- autovacuum insert-only tables more frequently to ensure most pages are visible for index-only scans
-------------------

alter table if exists crypto_transfer set (
    autovacuum_vacuum_insert_scale_factor = 0,
    autovacuum_vacuum_insert_threshold = ${autovacuumVacuumInsertThresholdCryptoTransfer},
    log_autovacuum_min_duration = 0
    );

alter table if exists token_transfer set (
    autovacuum_vacuum_insert_scale_factor = 0,
    autovacuum_vacuum_insert_threshold = ${autovacuumVacuumInsertThresholdTokenTransfer},
    log_autovacuum_min_duration = 0
    );

alter table if exists transaction set (
    autovacuum_vacuum_insert_scale_factor = 0,
    autovacuum_vacuum_insert_threshold = ${autovacuumVacuumInsertThresholdTransaction},
    log_autovacuum_min_duration = 0
    );
