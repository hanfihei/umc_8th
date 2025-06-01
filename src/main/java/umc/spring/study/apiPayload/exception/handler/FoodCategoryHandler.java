package umc.spring.study.apiPayload.exception.handler;

import umc.spring.study.apiPayload.code.BaseErrorCode;

public class FoodCategoryHandler extends GeneralException {
  public FoodCategoryHandler(BaseErrorCode errorCode) {
    super(errorCode);
  }
}
