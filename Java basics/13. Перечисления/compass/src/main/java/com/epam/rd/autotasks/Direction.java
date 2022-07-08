package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        while (degrees < 0) {
            degrees += 360;
        }
        while (degrees >= 360) {
            degrees -= 360;
        }

        Direction[] directions = Direction.values();
        for (Direction direction : directions) {
            if (direction.degrees == degrees) {
                return direction;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        while (degrees < 0) {
            degrees += 360;
        }
        while (degrees >= 360) {
            degrees -= 360;
        }
        if (ofDegrees(degrees) != null) {
            return ofDegrees(degrees);
        }

        Direction closestDirection = Direction.N;
        Direction[] directions = Direction.values();
        for (Direction direction : directions) {
            if (Math.abs(direction.degrees - degrees) < Math.abs(closestDirection.degrees - degrees)) {
                closestDirection = direction;
            }
        }
        return closestDirection;
    }

    public Direction opposite() {
        int degreeToFind = this.degrees;
        if (this.degrees >= 180) {
            degreeToFind -= 180;
        } else {
            degreeToFind += 180;
        }
        return ofDegrees(degreeToFind);
    }

    public int differenceDegreesTo(Direction direction) {
        int degrees = Math.abs(this.degrees - direction.degrees);
        if (degrees > 180) {
            degrees = Math.abs(degrees - 360);
        }
        return degrees;
    }
}
