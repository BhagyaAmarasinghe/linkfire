package lk.web.linkfirerestservice.service;

import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl implements NumberService {

	@Override public boolean isOdd(Integer number) {
		return (number % 2) != 0;
	}

}
