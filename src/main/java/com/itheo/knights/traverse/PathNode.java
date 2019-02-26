package com.itheo.knights.traverse;

import java.util.List;

public interface PathNode {
    <N extends Node> N getCurrent();
    List<PathNode> getSuccessors();
    <N extends Node> List<N> getPath();
}
