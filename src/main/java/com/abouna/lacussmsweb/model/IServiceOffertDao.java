/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abouna.lacussmsweb.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author SATELLITE
 */
public interface IServiceOffertDao extends JpaRepository<ServiceOffert, Integer>{
    public List<ServiceOffert> findServiceOffertByActifTrue();
}
