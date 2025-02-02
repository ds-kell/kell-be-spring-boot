package vn.com.dsk.demo.features.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.dsk.demo.features.domain.entities.Product;

public interface ProductJPARepository extends JpaRepository<Product, Long> {
}
