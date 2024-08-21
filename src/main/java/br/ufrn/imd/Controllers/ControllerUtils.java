package br.ufrn.imd.Controllers;

import java.util.List;

public interface ControllerUtils<T> {
    Object[][] convertListToArray(List<T> list);
}

