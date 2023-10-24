package com.quiz.weather_history.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

@Service //모든 조건을 가져올 것
public class WeatherHistoryBO {
	
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	//input
	//output : List<WeatherHistory>
	public List<WeatherHistory> getWeatherHistory() {
		return weatherHistoryMapper.selectWeatherHistory();
	}
	
	public void addWeatherHistory(String date, String weather, String microDust, double temperatures, double precipitation, String windSpeed) {
		weatherHistoryMapper.insertWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
	}
 }
