Сделал два примера использования rxjava:
1 - Observable.create в getTextFromNetwork() - метод для создания Observable. Внутри него мы можем вручную определить события, 
которые будут выдаваться подписчику. onNext - определяет события.
2 - в onCreate мы сразу работаем с Observable. Тут мы сразу можем использовать subscribeOn или observeOn.