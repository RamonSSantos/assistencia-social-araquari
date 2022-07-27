package br.com.asa.dtos;

import br.com.asa.models.DepartmentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubdepartmentDto {
    private int id;
    private String description;
    private DepartmentEntity department;
}
