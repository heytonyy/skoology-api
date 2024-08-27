package com.heytonyy.skoologyapi.Gradebook;


import com.heytonyy.skoologyapi.Teacher.Teacher;

import java.util.List;

public interface IGradebookService {
    List<Gradebook> getAllGradebooks();
    Gradebook createGradebook(int teacherId);
    Gradebook getGradebookById(int id);
    boolean deleteGradebookById(int id);
    boolean updateGradebook(int id, Gradebook updatedGradebook);
}
