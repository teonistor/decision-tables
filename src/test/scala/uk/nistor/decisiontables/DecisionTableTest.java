package uk.nistor.decisiontables;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import scala.collection.immutable.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


class DecisionTableTest {

    @Mock
    private List<DecisionRule<String>> rules;

    @BeforeEach
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void toStringDelegatesToList() {
        when(rules.toString()).thenReturn("Bla bla");

        assertThat(new DecisionTable<String>(rules).toString()).isEqualTo("Bla bla");
    }
}
