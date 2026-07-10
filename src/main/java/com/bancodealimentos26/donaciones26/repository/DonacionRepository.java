package com.bancodealimentos26.donaciones26.repository;

import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.bancodealimentos26.donaciones26.model.Donacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonacionRepository extends JpaRepository<Donacion, Long> {

    @Query("""
SELECT MONTH(d.fecha), COUNT(d)
FROM Donacion d
GROUP BY MONTH(d.fecha)
ORDER BY MONTH(d.fecha)
""")
List<Object[]> obtenerDonacionesPorMes();
}

