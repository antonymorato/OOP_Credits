package kpi.iasa.controller;
/**
 * Created by
 * @author Anton Korol
 * on Feb 20, 2020
 */
public interface RegexContainer {


    String REGEX_NAME = "^[A-Z][a-z]{1,20}$|^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String REGEX_NUMBER = "^[0-9]+$";

}
