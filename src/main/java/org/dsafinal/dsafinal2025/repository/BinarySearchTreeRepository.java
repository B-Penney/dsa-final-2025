package org.dsafinal.dsafinal2025.repository;

import org.dsafinal.dsafinal2025.model.BinarySearchTreeResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinarySearchTreeRepository extends JpaRepository<BinarySearchTreeResult, Long> {
}
