package com.code.mapper;

public interface IMapper <I, O>{
	O map(I in);
}
