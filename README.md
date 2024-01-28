Hanoi Tower
---
Simple java program that solve hanoi tower with implementation of stack in linkedlist

My Algorithm
--
1. Create three Towers tower1, tower2, tower3.
2. Set tower1 as currentTower
3. if tower1 is currentTower set evenToTower to tower2, oddToTower to tower3
4. if tower2 is currentTower set evenToTower to tower1, oddToTower to tower3
5. if tower3 is currentTower set evenToTower to tower1, oddToTower to tower2
6.Now for pushing disk if tower3 size is even push to evenToTower else push to oddToTower
7. When not pushable (ie. current top value is greater than other towers top values. or disks are empty).
  if disk count is even or 0 change current tower to evenToTower.
  else change current tower to oddToTower.
8. Repeat the steps in while loops until the third tower is solved (ie. tower3 top == 1 and tower2 and tower1 top == null)
