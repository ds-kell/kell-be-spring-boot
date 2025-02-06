package vn.com.dsk.demo.base.shared.common;

@FunctionalInterface
public interface UseCaseNoParam<RESULT> {
    RESULT execute();
}