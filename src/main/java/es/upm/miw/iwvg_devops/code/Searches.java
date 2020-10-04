package es.upm.miw.iwvg_devops.code;

import org.apache.logging.log4j.LogManager;

import java.util.Optional;
import java.util.stream.Stream;

public class Searches {
        //通过不同的用户名查找用户的姓
    public Stream<String> findUserFamilyNameByUserNameDistinct(String userName) {
        return new UsersDatabase().findAll()
                .filter(user -> userName.equals(user.getName()))
                .map(User::getFamilyName)
                .distinct();
    }
        //通过用户的姓找分数分子
    public Stream<Integer> findFractionNumeratorByUserFamilyName(String userFamilyName) {
        return new UsersDatabase().findAll()
                .peek(x -> LogManager.getLogger(this.getClass()).info("before: " + x))
                .filter(user -> userFamilyName.equals(user.getFamilyName()))
                .peek(x -> LogManager.getLogger(this.getClass()).info("after: " + x))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::getNumerator);
    }
        //通过分数分母找用户的姓
    public Stream<String> findUserFamilyNameByFractionDenominator(int fractionDenominator) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fractionDenominator == fraction.getDenominator()))
                .map(User::getFamilyName);
    }
        //通过真分数查找用户姓首字母
    public Stream<String> findUserFamilyNameInitialBySomeProperFraction(int anyProperFraction) { return Stream.empty(); }
        //通过任意真分数查找用户ID
    public Stream<String> findUserIdBySomeProperFraction(boolean fractionProper) {
            return new UsersDatabase().findAll()
                    .filter(user -> user.getFractions().stream()
                            .anyMatch(fraction -> fractionProper == fraction.isProper(fraction.getNumerator(),fraction.getDenominator())))
                    .map(User::getId);
    }
        //通过用户的姓查找分数乘法
    public Fraction findFractionMultiplicationByUserFamilyName(String familyName) {return null; }
        //通过用户ID查找第一次分数的除法
    public Fraction findFirstFractionDivisionByUserId(String id) {
        return null;
    }
        //通过用户名查找第一个小数
    public Double findFirstDecimalFractionByUserName(String name) {
        return null;
    }
        //通过所有真分数查找用户的ID
    public Stream<String> findUserIdByAllProperFraction(int allProperFraction) {
        return Stream.empty();
    }
        //通过用户名查找十进制假分数
    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return Stream.empty();
    }
        //通过用户ID查找第一个真分数
    public Fraction findFirstProperFractionByUserId(String id) {
        return null;
    }
        //通过假分数查找用户姓
    public Stream<String> findUserFamilyNameByImproperFraction() {
        return Stream.empty();
    }
        //查找最高的分数
    public Fraction findHighestFraction() {
        return null;
    }
        //通过任意一个假分数查找用户名
    public Stream<String> findUserNameByAnyImproperFraction() {
        return Stream.empty();
    }
        //通过所有负分数查找用户的姓
    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return Stream.empty();
    }
        //通过负分数查找小数
    public Stream<Double> findDecimalFractionByNegativeSignFraction(int negativeSignFraction) {
        String string=String.valueOf(negativeSignFraction);
        return (Stream<Double>) new UsersDatabase().findAll()
                .filter(user -> string.equals(user.getFractions().toString()))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::decimal);
    }

        //通过用户ID查找分数加法
    public Fraction findFractionAdditionByUserId(String id) {
        return (Fraction) new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::add);
    }

        //通过用户名查找第一次分数减法
    public Optional<Fraction> findFirstFractionSubtractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::subtraction)
                .findFirst();
    }

}
