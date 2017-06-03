/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.first8.hu.ticketsale.sales;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Rik_k
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AuditTrail implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;

    private Long sale_id;
    
    private Long account_id;
}
