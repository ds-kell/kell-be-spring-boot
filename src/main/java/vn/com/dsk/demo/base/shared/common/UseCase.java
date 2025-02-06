package vn.com.dsk.demo.base.shared.common;

@FunctionalInterface
public interface UseCase<RESULT, PARAMS> {
    RESULT execute(PARAMS params);
}