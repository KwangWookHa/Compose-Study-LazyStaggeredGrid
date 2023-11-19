package kwangwook.compose.study.lazystaggeredgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kwangwook.compose.study.lazystaggeredgrid.ui.ListItem
import kwangwook.compose.study.lazystaggeredgrid.ui.RandomColorBox
import kwangwook.compose.study.lazystaggeredgrid.ui.theme.ComposeStudyLazyStaggeredGridTheme

class MainActivity : ComponentActivity() {

    companion object {
        private const val STAGGERED_GRID_CELLS_COUNT = 3
    }

    private val exampleItems = List(100) {
        ListItem(
            height = (100..300).random().dp,
            color = Color((0xFF000000..0xFFFFFFFF).random()).copy(alpha = 1f)
        )
    }

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyLazyStaggeredGridTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainScreenGrid(
                        modifier = Modifier.fillMaxSize(),
                        columns = StaggeredGridCells.Adaptive(40.dp)
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun MainScreenGrid(
        modifier: Modifier = Modifier,
        columns : StaggeredGridCells
    ) {
        LazyVerticalStaggeredGrid(
            modifier = modifier,
            columns = columns,
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalItemSpacing = 16.dp
        ) {
            items(exampleItems) {
                RandomColorBox(it)
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Preview(showBackground = true)
    @Composable
    fun MainScreenFixedGrid() {
        MainScreenGrid(
            modifier = Modifier.fillMaxSize(),
            columns = StaggeredGridCells.Fixed(STAGGERED_GRID_CELLS_COUNT)
        )
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Preview(showBackground = true)
    @Composable
    fun MainScreenFixedGrid5() {
        MainScreenGrid(
            modifier = Modifier.fillMaxSize(),
            columns = StaggeredGridCells.Fixed(5)
        )
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Preview(showBackground = true)
    @Composable
    fun MainScreenAdaptiveGrid() {
        MainScreenGrid(
            modifier = Modifier.fillMaxSize(),
            columns = StaggeredGridCells.Adaptive(40.dp)
        )
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Preview(showBackground = true)
    @Composable
    fun MainScreenAdaptiveGrid16dp() {
        MainScreenGrid(
            modifier = Modifier.fillMaxSize(),
            columns = StaggeredGridCells.Adaptive(16.dp)
        )
    }

}