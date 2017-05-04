package terrails.ingotter.worldgen.ore;

import com.google.common.base.CharMatcher;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public class StringChecker {


    @SuppressWarnings("deprecation")
    public static IBlockState generatingBlock(String string) {
        if (!string.isEmpty()) {
            int metadata = string.contains(" -meta:") ? blockMeta(string) : 0;
            String blockString = string.substring(0, string.indexOf(" -"));
            Block theBlock = Block.getBlockFromName(blockString);
            IBlockState blockState = theBlock != null ? theBlock.getStateFromMeta(metadata) : null;
            return blockState;
        }
        return null;
    }
    private static int blockMeta(String string) {
        if (string.contains(" -meta:")) {
            String metaDataString = string.replaceAll("^.*( -meta:\\d+).*$", "$1");
            String metaDataDigit = CharMatcher.DIGIT.retainFrom(metaDataString);
            int metaData = Integer.parseInt(metaDataDigit);
            return metaData;
        }
        else return 0;
    }

    @SuppressWarnings("deprecation")
    public static Block replaceBlock(String string) {
        if (string.contains("-replace:")) {
            String replace1 = string.substring(string.indexOf("-replace:")).replace("-replace:", "");
            String replace2 = replace1.contains(" -") ? replace1.replaceAll("([\\s]).*", "$1").replace(" ", "") : replace1.replace(";", "");

            // Multiple replace blocks dont work so this isn't usable but its there just because reasons!
            if (replace2.contains("|")) {
                Block replaceBlock = null;
                String[] splitArray = replace2.split("\\|");
                for (String replace : splitArray) {
                    int metadata = replace.contains("-meta:") ? replacingMetadata(replace) : 0;
                    String theReplaceBlock = replace.contains("-meta:") ? replace.substring(0, replace.indexOf("-meta:")) : replace;
                    Block theBlock = Block.getBlockFromName(theReplaceBlock);
                    Block blockState = theBlock != null ? theBlock.getStateFromMeta(metadata).getBlock() : null;
                    replaceBlock = blockState;
                }
                return replaceBlock;
            }

            else if (!replace2.contains("|")) {
                Block replaceBlock = null;
                int metadata = replace2.contains("-meta:") ? replacingMetadata(replace2) : 0;
                String theReplaceBlock = replace2.contains("-meta:") ? replace2.substring(0, replace2.indexOf("-meta:")) : replace2;
                Block theBlock = Block.getBlockFromName(theReplaceBlock);
                Block blockState = theBlock != null ? theBlock.getStateFromMeta(metadata).getBlock() : null;
                replaceBlock = blockState;
                return replaceBlock;
            }
        }
        return null;
    }
    private static int replacingMetadata(String string) {
        if (string.contains("-meta:")) {
         //   int meta = 0;
            //   String[] array = string.split("\\|");

            //     for (String replace3 : array) {
            String metaDataString = string.replaceAll("^.*(-meta:\\d+).*$", "$1");
            String metaDataDigit = CharMatcher.DIGIT.retainFrom(metaDataString);
            int metaData = Integer.parseInt(metaDataDigit);
         //   meta = metaData;
            //     }
            return metaData;
        }
        else return 0;
    }

    public static int minVein(String string) {
        if (string.contains("-minvein:")) {
            String stringMinVein = string.replaceAll("^.*( -minvein:\\d+).*$", "$1");
            String digitMinVein = CharMatcher.DIGIT.retainFrom(stringMinVein);
            int minVein = Integer.parseInt(digitMinVein);
            return minVein;
        }
        return 0;
    }
    public static int maxVein(String string) {
        if (string.contains("-maxvein:")) {
            String stringMaxVein = string.replaceAll("^.*( -maxvein:\\d+).*$", "$1");
            String digitMaxVein = CharMatcher.DIGIT.retainFrom(stringMaxVein);
            int maxVein = Integer.parseInt(digitMaxVein);
            return maxVein;
        }
        return 0;
    }

    public static int minY(String string) {
        if (string.contains("-miny:")) {
            String stringMinY = string.replaceAll("^.*( -miny:\\d+).*$", "$1");
            String digitMinY = CharMatcher.DIGIT.retainFrom(stringMinY);
            int minY = Integer.parseInt(digitMinY);
            return minY;
        }
        return 0;
    }
    public static int maxY(String string) {
        if (string.contains("-maxy:")) {
            String stringMaxY = string.replaceAll("^.*( -maxy:\\d+).*$", "$1");
            String digitMaxY = CharMatcher.DIGIT.retainFrom(stringMaxY);
            int maxY = Integer.parseInt(digitMaxY);
            return maxY;
        }
        return 0;
    }

    public static int perChunk(String string) {
        if (string.contains("-perchunk:")) {
            String stringPerChunk = string.replaceAll("^.*( -perchunk:\\d+).*$", "$1");
            String digitPerChunk = CharMatcher.DIGIT.retainFrom(stringPerChunk);
            int perChunk = Integer.parseInt(digitPerChunk);
            return perChunk;
        }
        return 0;
    }

    public static int biomeID(String string) {
        if (string.contains("-biome:")) {
            String biome1 = string.substring(string.indexOf("-biome:")).replace("-biome:", "");
            String biome2 = biome1.contains(" -") ? biome1.substring(0, biome1.indexOf(" ")) : biome1.replace(";", "");
            if (!biome2.contains("|")) {
                int biomeID = Integer.parseInt(biome2);
                return biomeID;
            } else if (biome2.contains("|")) {
                int biID = 0;
                String[] biome3 = biome2.split("\\|");
                for (String biome : biome3) {
                    int biomeID = Integer.parseInt(biome);
                    biID = biomeID;
                    //System.out.println("biome:" + biome);
                }
                return biID;
            }
        }
        return 0;
    }
    public static int dimensionID(String string) {
        if (string.contains("-dimension:")) {
            String dim1 = string.substring(string.indexOf("-dimension:")).replace("-dimension:", "");
            String dim2 = dim1.contains(" -") ? dim1.substring(0, dim1.indexOf(" ")) : dim1.replace(";", "");
            if (!dim2.contains("|")) {
                return Integer.parseInt(dim2);

            }
            else if (dim2.contains("|")) {
                int dimID = 0;
                String[] dim3 = dim2.split("\\|");
                for (String dim : dim3) {
                    dimID = Integer.parseInt(dim);
                }
                return dimID;
            }
        }
        return 0;
    }


    /*
    @SuppressWarnings("deprecation")
    public static IBlockState generatingBlock(String string) {
        if (!string.isEmpty()) {
            String blockString = string.substring(0, string.indexOf(" -"));
            Block theBlock = Block.getBlockFromName(blockString);
            if (theBlock != null) {
                IBlockState blockState = theBlock.getStateFromMeta(blockMeta(string));
                return blockState;
            }
        }
        return null;
    }
    private static int blockMeta(String string) {
        if (string.contains(" -meta:")) {
            String metaDataString = string.replace("^.*( -meta:\\d+).*$", "$1");
            String metaDataDigit = CharMatcher.DIGIT.retainFrom(metaDataString);
            int metaData = Integer.parseInt(metaDataDigit);
            //    this.metaData = metaData;
            return metaData;
        } else return 0;
    }

    @SuppressWarnings("deprecation")
    public static Block replaceBlock(String string) {
        if (string.contains("-replace:")) {
            String replace1 = string.substring(string.indexOf("-replace:")).replace("-replace:", "");
            String replace2 = replace1.contains(" -") ? replace1.substring(0, replace1.indexOf(" -")) : replace1.replace(";", "");

            if (replace2.contains("metareplace:")) {
                String blockString = replace2.substring(0, replace2.indexOf(" metareplace:"));
                Block theBlock = Block.getBlockFromName(blockString);
                return theBlock.getStateFromMeta(replacingMetadata(string)).getBlock();
            } else return Block.getBlockFromName(replace2);
        }
        return null;
    }
    private static int replacingMetadata(String string) {
        if (string.contains("-replace:")) {
            String replace1 = string.substring(string.indexOf("-replace:")).replace("-replace:", "");
            String replace2 = replace1.contains(" -") ? replace1.substring(0, replace1.indexOf(" -")) : replace1.replace(";", "");

            if (replace2.contains("metareplace:")) {
                String meta1 = replace2.substring(string.indexOf("metareplace"));
                String meta2 = meta1.contains(" -") ? meta1.substring(0, meta1.indexOf(" -")) : meta1.replace(";", "");
                String metaDigit = CharMatcher.DIGIT.retainFrom(meta2);
                int metaData = Integer.parseInt(metaDigit);
                return metaData;
            } else return 0;
        }
        return 0;
    }

    public static int minVein(String string) {
        if (string.contains("-minvein:")) {
            String stringMinVein = string.replaceAll("^.*( -minvein:\\d+).*$", "$1");
            String digitMinVein = CharMatcher.DIGIT.retainFrom(stringMinVein);
            int minVein = Integer.parseInt(digitMinVein);
            return minVein;
        }
        return 0;
    }
    public static int maxVein(String string) {
        if (string.contains("-maxvein:")) {
            String stringMaxVein = string.replaceAll("^.*( -maxvein:\\d+).*$", "$1");
            String digitMaxVein = CharMatcher.DIGIT.retainFrom(stringMaxVein);
            int maxVein = Integer.parseInt(digitMaxVein);
            return maxVein;
        }
        return 0;
    }

    public static int minY(String string) {
        if (string.contains("-miny:")) {
            String stringMinY = string.replaceAll("^.*( -miny:\\d+).*$", "$1");
            String digitMinY = CharMatcher.DIGIT.retainFrom(stringMinY);
            int minY = Integer.parseInt(digitMinY);
            return minY;
        }
        return 0;
    }
    public static int maxY(String string) {
        if (string.contains("-maxy:")) {
            String stringMaxY = string.replaceAll("^.*( -maxy:\\d+).*$", "$1");
            String digitMaxY = CharMatcher.DIGIT.retainFrom(stringMaxY);
            int maxY = Integer.parseInt(digitMaxY);
            return maxY;
        }
        return 0;
    }

    public static int perChunk(String string) {
        if (string.contains("-perchunk:")) {
            String stringPerChunk = string.replaceAll("^.*( -perchunk:\\d+).*$", "$1");
            String digitPerChunk = CharMatcher.DIGIT.retainFrom(stringPerChunk);
            int perChunk = Integer.parseInt(digitPerChunk);
            return perChunk;
        }
        return 0;
    }

    public static int biomeID(String string) {
        if (string.contains("-biome:")) {
            String biome1 = string.substring(string.indexOf("-biome:")).replace("-biome:", "");
            String biome2 = biome1.contains(" -") ? biome1.substring(0, biome1.indexOf(" ")) : biome1.replace(";", "");
            if (!biome2.contains("|")) {
                int biomeID = Integer.parseInt(biome2);
                return biomeID;
                //System.out.println(biome2);
            } else if (biome2.contains("|")) {
                String[] biome3 = biome2.split("\\|");
                for (String biome : biome3) {
                    int biomeID = Integer.parseInt(biome);
                    return biomeID;
                    //System.out.println("biome:" + biome);
                }
            }
        }
        return 0;
    }
    public static int dimensionID(String string) {
        if (string.contains("-dimension:")) {
            String dim1 = string.substring(string.indexOf("-dimension:")).replace("-dimension:", "");
            String dim2 = dim1.contains(" -") ? dim1.substring(0, dim1.indexOf(" ")) : dim1.replace(";", "");
            if (!dim2.contains("|")) {
                int dimensionID = Integer.parseInt(dim2);
                return dimensionID;
                //System.out.println(dim2);
            } else if (dim2.contains("|")) {
                String[] dim3 = dim2.split("\\|");
                for (String dim : dim3) {
                    int dimensionID = Integer.parseInt(dim);
                    return dimensionID;
                    //System.out.println("dimension:" + dim);
                }
            }
        }
        return 0;
    }
    */
}



    




/*
    @SuppressWarnings("deprecation")
    private void generateCustom(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        for (String ore : ConfigOreHandler.oreArray) {
            String oreName = ore.toLowerCase();

            // Ore Name
            String nameOfOre = StringUtils.substringBefore(oreName, " -");
            Block blockOre = Block.getBlockFromName(nameOfOre);
            //System.out.println(nameOfOre);

            if(blockOre != null){
            //Metadata
               if(oreName.contains("-replace:")){
               String metaChecker = StringUtils.substringBefore(oreName, "-replace:");
               this.metaChecker = metaChecker;
           }
            if (metaChecker.contains("-meta:") && oreName.contains("-meta:")) {
                String meta1 = oreName.substring(oreName.indexOf("-meta:")).replace("-meta:", "");
                String meta2 = meta1.contains(" -") ? meta1.substring(0, meta1.indexOf(" ")) : meta1.replace(";", "");
                oreMetadata = Integer.parseInt(meta2);
                //System.out.println(oreMetadata);
            } else if (oreName.contains("-meta:")){
                String meta1 = oreName.substring(oreName.indexOf("-meta:")).replace("-meta:", "");
                String meta2 = meta1.contains(" -") ? meta1.substring(0, meta1.indexOf(" ")) : meta1.replace(";", "");
                oreMetadata = Integer.parseInt(meta2);
            }


            // IBlockState
                IBlockState blockStateOre = blockOre.getStateFromMeta(oreMetadata);
                oreBlock = blockStateOre;

            // Min Vein
            if (oreName.contains("-minvein:")) {
                String minVein1 = oreName.substring(oreName.indexOf("-minvein:")).replace("-minvein:", "");
                String minVein2 = minVein1.contains(" -") ? minVein1.substring(0, minVein1.indexOf(" ")) : minVein1.replace(";", "");
                minVein = Integer.parseInt(minVein2);
                //System.out.println(minVein);
            }

            // Max Vein Size
            if (oreName.contains("-maxvein:")) {
                String maxVein1 = oreName.substring(oreName.indexOf("-maxvein:")).replace("-maxvein:", "");
                String maxVein2 = maxVein1.contains(" -") ? maxVein1.substring(0, maxVein1.indexOf(" ")) : maxVein1.replace(";", "");
                maxVein = Integer.parseInt(maxVein2);
                //System.out.println(maxVein);
            }

            // Min Y Level
            if (oreName.contains("-miny:")) {
                String miny1 = oreName.substring(oreName.indexOf("-miny:")).replace("-miny:", "");
                String miny2 = miny1.contains(" -") ? miny1.substring(0, miny1.indexOf(" ")) : miny1.replace(";", "");
                minY = Integer.parseInt(miny2);
                //System.out.println(minY);
            }

            // Max Y Level
            if (oreName.contains("-maxy:")) {
                String maxy1 = oreName.substring(oreName.indexOf("-maxy:")).replace("-maxy:", "");
                String maxy2 = maxy1.contains(" -") ? maxy1.substring(0, maxy1.indexOf(" ")) : maxy1.replace(";", "");
                maxY = Integer.parseInt(maxy2);
                //System.out.println(maxY);
            }

            // Veins Per Chunk
            if (oreName.contains("-perchunk:")) {
                String perChunk1 = oreName.substring(oreName.indexOf("-perchunk:")).replace("-perchunk:", "");
                String perChunk2 = perChunk1.contains(" -") ? perChunk1.substring(0, perChunk1.indexOf(" ")) : perChunk1.replace(";", "");
                perChunk = Integer.parseInt(perChunk2);
                //System.out.println(perChunk);
            }

            // Dimension
            if (oreName.contains("-dimension:")) {
                String dim1 = oreName.substring(oreName.indexOf("-dimension:")).replace("-dimension:", "");
                String dim2 = dim1.contains(" -") ? dim1.substring(0, dim1.indexOf(" ")) : dim1.replace(";", "");
                if (!dim2.contains(".")) {dimID = Integer.parseInt(dim2);}
                else if (dim2.contains(".")) {String[] dim3 = dim2.split("\\.");
                for (String dim : dim3) {dimID = Integer.parseInt(dim);}}
                //System.out.println(dimID);
            }

            // Block To Replace
            if(oreName.contains("-replace:")){
                String metaAfterReplace = StringUtils.substringAfter(oreName, "-replace:");
                String metaAfter = metaAfterReplace.contains(" -") ? StringUtils.substringBefore(metaAfterReplace," -") : metaAfterReplace.replace(";", "");
                replaceMetaChecker = metaAfter;
            }

            if (replaceMetaChecker.contains("-meta:") && oreName.contains("-replace:")) {
                String replace1 = oreName.substring(oreName.indexOf("-replace:")).replace("-replace:", "");
                String replace2 = replace1.contains(" -") ? replace1.substring(0, replace1.indexOf(" ")) : replace1.replace(";", "");
                if (!replace2.contains(".") && !replace2.contains("-meta:")) {blockReplace = Block.getBlockFromName(replace2);}
                else if(!replace2.contains(".") && replace2.contains("-meta:")){
                    String meta1 = replace2.substring(replace2.indexOf("-meta:")).replace("-meta:", "");
                    //  int replaceMeta = Integer.parseInt(meta1);
                   // String block =
                }
                else if (replace2.contains(".")) {String[] replace3 = replace2.split("\\.");
                for (String block : replace3) {blockReplace = Block.getBlockFromName(block);}}
            }

            else if (oreName.contains("-replace:")) {
                String replace1 = oreName.substring(oreName.indexOf("-replace:")).replace("-replace:", "");
                String replace2 = replace1.contains(" -") ? replace1.substring(0, replace1.indexOf(" ")) : replace1.replace(";", "");
                if (!replace2.contains(".")) {blockReplace = Block.getBlockFromName(replace2);}
                else if (replace2.contains(".")) {String[] replace3 = replace2.split("\\.");
                for (String block : replace3) {blockReplace = Block.getBlockFromName(block);}}
                }

            // Biome
            if (oreName.contains("-biome:")) {
                String biome1 = oreName.substring(oreName.indexOf("-biome:")).replace("-biome:", "");
                String biome2 = biome1.contains(" -") ? biome1.substring(0, biome1.indexOf(" ")) : biome1.replace(";", "");
                if (!biome2.contains(".")) {biomeID = Integer.parseInt(biome2);}
                else if (biome2.contains(".")) {String[] biome3 = biome2.split("\\.");
                for (String biome : biome3) {biomeID = Integer.parseInt(biome);}}
            }
            boolean dimension = oreName.contains("-dimension:");
            boolean biome = oreName.contains("-biome:");
            boolean blockToReplace = oreName.contains("-replace:");

            if(!dimension && !biome && !blockToReplace){
                generateNormal(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk);
            }
            if(!dimension && !biome && blockToReplace){
                generateReplace(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, blockReplace);
            }
            if(!dimension && biome && blockToReplace){
                generateBiomeReplace(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, biomeID, blockReplace);
            }
            if(dimension && biome && blockToReplace) {
                generateDimBiomeReplace(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, dimID, biomeID, blockReplace);
            }
            if(dimension && biome && !blockToReplace){
                generateDimBiome(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, dimID, biomeID);
            }
            if(dimension && !biome && !blockToReplace){
                generateDim(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, dimID);
            }
            if(!dimension && biome && !blockToReplace){
                generateBiome(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, biomeID);
            }
            if(dimension && !biome && blockToReplace){
                generateDimReplace(oreBlock, world, random, chunkX, chunkZ, minY, maxY, minVein, maxVein, perChunk, dimID, blockReplace);
            }}
        }
    }
*/
