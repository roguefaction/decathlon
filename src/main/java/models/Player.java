package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Player {

    private String name;
    private double benchmark100mInSeconds;
    private double benchmarkLongJumpInMetres;
    private double benchmarkShotPutInMetres;
    private double benchmarkHighJumpInMetres;
    private double benchmark400mInSeconds;
    private double benchmark110mHurdlesInSeconds;
    private double benchmarkDiscusThrowInMetres;
    private double benchmarkPoleVaultInMetres;
    private double benchmarkJavelinThrowInMetres;
    private String benchmark1500mInMinutes;
    private int overallPoints;
    private String placeInCompetition;

    public Player() {
        // mainly used for testing
    }

    public Player(String[] attributes) {
        this.name = attributes[0];
        this.benchmark100mInSeconds = Double.parseDouble(attributes[1]);
        this.benchmarkLongJumpInMetres = Double.parseDouble(attributes[2]);
        this.benchmarkShotPutInMetres = Double.parseDouble(attributes[3]);
        this.benchmarkHighJumpInMetres = Double.parseDouble(attributes[4]);
        this.benchmark400mInSeconds = Double.parseDouble(attributes[5]);
        this.benchmark110mHurdlesInSeconds = Double.parseDouble(attributes[6]);
        this.benchmarkDiscusThrowInMetres = Double.parseDouble(attributes[7]);
        this.benchmarkPoleVaultInMetres = Double.parseDouble(attributes[8]);
        this.benchmarkJavelinThrowInMetres = Double.parseDouble(attributes[9]);
        this.benchmark1500mInMinutes = attributes[10];
    }

    public double getBenchmark100mInSeconds() {
        return benchmark100mInSeconds;
    }

    public void setBenchmark100mInSeconds(double benchmark100mInSeconds) {
        this.benchmark100mInSeconds = benchmark100mInSeconds;
    }

    public double getBenchmarkLongJumpInMetres() {
        return benchmarkLongJumpInMetres;
    }

    public void setBenchmarkLongJumpInMetres(double benchmarkLongJumpInMetres) {
        this.benchmarkLongJumpInMetres = benchmarkLongJumpInMetres;
    }

    public double getBenchmarkShotPutInMetres() {
        return benchmarkShotPutInMetres;
    }

    public void setBenchmarkShotPutInMetres(double benchmarkShotPutInMetres) {
        this.benchmarkShotPutInMetres = benchmarkShotPutInMetres;
    }

    public double getBenchmarkHighJumpInMetres() {
        return benchmarkHighJumpInMetres;
    }

    public void setBenchmarkHighJumpInMetres(double benchmarkHighJumpInMetres) {
        this.benchmarkHighJumpInMetres = benchmarkHighJumpInMetres;
    }

    public double getBenchmark400mInSeconds() {
        return benchmark400mInSeconds;
    }

    public void setBenchmark400mInSeconds(double benchmark400mInSeconds) {
        this.benchmark400mInSeconds = benchmark400mInSeconds;
    }

    public double getBenchmark110mHurdlesInSeconds() {
        return benchmark110mHurdlesInSeconds;
    }

    public void setBenchmark110mHurdlesInSeconds(double benchmark110mHurdlesInSeconds) {
        this.benchmark110mHurdlesInSeconds = benchmark110mHurdlesInSeconds;
    }

    public double getBenchmarkDiscusThrowInMetres() {
        return benchmarkDiscusThrowInMetres;
    }

    public void setBenchmarkDiscusThrowInMetres(double benchmarkDiscusThrowInMetres) {
        this.benchmarkDiscusThrowInMetres = benchmarkDiscusThrowInMetres;
    }

    public double getBenchmarkPoleVaultInMetres() {
        return benchmarkPoleVaultInMetres;
    }

    public void setBenchmarkPoleVaultInMetres(double benchmarkPoleVaultInMetres) {
        this.benchmarkPoleVaultInMetres = benchmarkPoleVaultInMetres;
    }

    public double getBenchmarkJavelinThrowInMetres() {
        return benchmarkJavelinThrowInMetres;
    }

    public void setBenchmarkJavelinThrowInMetres(double benchmarkJavelinThrowInMetres) {
        this.benchmarkJavelinThrowInMetres = benchmarkJavelinThrowInMetres;
    }

    public String getBenchmark1500mInMinutes() {
        return benchmark1500mInMinutes;
    }

    public void setBenchmark1500mInMinutes(String benchmark1500mInMinutes) {
        this.benchmark1500mInMinutes = benchmark1500mInMinutes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceInCompetition() {
        return placeInCompetition;
    }

    public int getOverallPoints() {
        return overallPoints;
    }

    public void setOverallPoints(int overallPoints) {
        this.overallPoints = overallPoints;
    }

    public void setPlaceInCompetition(String placeInCompetition) {
        this.placeInCompetition = placeInCompetition;
    }
}
