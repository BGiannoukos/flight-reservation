package com.bill.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bill.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
