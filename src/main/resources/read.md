## 全域例外錯誤處理
com.example.demo.handler.GlobalExceptionHandler

## API 例外處理
com.example.demo.exception.APIException

## 所有中文語言包
com.example.demo.util.Language

## 回傳狀態
com.example.demo.util.Result

流程 : 當丟出一個API例外時，GlobalExceptionHandler會去處理對應的例外，接著丟出一個result物件
